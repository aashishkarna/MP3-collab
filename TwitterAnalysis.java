package twitterAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class TwitterAnalysis {
    private static final Graph twitter = new AdjacencyListGraph();
    
    public static void main(String[] args) throws IOException {
        //Ask for input and output file name
      System.out.println("Enter input file name: ");
      Scanner scanner = new Scanner(System.in);
      String inputFileName = scanner.nextLine();
      System.out.println("Enter output file name: ");
      String outputFileName = scanner.nextLine();
      
      grapher();
      System.out.println(twitter.getVertices());
      System.out.println("graph done");
      LinkedList<String[]> queryList = reader(inputFileName);
      System.out.println("reader done");
      query(queryList,outputFileName);
      System.out.println("done");
                
    }
    
    /**
     * @modifies Graph twitter to contain the vertices and edges as represented in the twitter.txt file
     * @throws FileNotFoundException
     */
    private static void grapher() {
        FileInputStream twitterStream;        
        try{
            
            twitterStream = new FileInputStream("twitter.txt");
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

        try{
            BufferedReader twitterReader = new BufferedReader(new InputStreamReader(twitterStream));
            String line;                
                
            while((line=twitterReader.readLine()) != null){
                
                String[] trim = line.split(" -> ");
                
                Vertex v = new Vertex(trim[0]);
                if(!twitter.getVertices().contains(v)){
                    twitter.addVertex(v);
                }
                Vertex w = new Vertex(trim[1]);
                if(!twitter.getVertices().contains(w)){
                    twitter.addVertex(w);
                }
                if(!twitter.edgeExists(v, w)){
                    twitter.addEdge(v, w);                    
                }               
            }twitterReader.close();            
        }catch(Exception e){
            
        }
    }
    
    /**
     * 
     * @param fileName a String containing the file name to be read, ending with .txt
     * @return LinkedList<String[]> of the query type, vertices a and b and "?" if written
     * in the correct format, that is "queryType a b ?" where each array of strings is unique
     * @throws FileNotFoundException
     */
    private static LinkedList<String[]> reader(String fileName) {

        
        FileInputStream queryStream;
        LinkedList<String> unique = new LinkedList<>();
        LinkedList<String[]> queryList = new LinkedList<>();
        try {
            queryStream = new FileInputStream(fileName);
        }
        catch (FileNotFoundException f){
            throw new RuntimeException(f);
        }
        try {
            BufferedReader queryReader = new BufferedReader(new InputStreamReader(queryStream));
            String line;
            while((line = queryReader.readLine()) != null) {
                if(!unique.contains(line)){
                	unique.add(line);
                	String[] blocks = line.split(" ");
                // blocks[0] is the query type
                // blocks[1] is userA
                // blocks[2] is userB
                // blocks[3] must be "?" to be considered
               
                	if(blocks.length == 4 && blocks[3].equals("?")) {
                		queryList.add(blocks);                    
                }
              }
            }
            queryReader.close();
            queryStream.close();
        }
        catch (Exception f) {
            throw new RuntimeException(f);
        }
        return queryList;
    }
    
    /**
     * 
     * @param queryList a LinkedLIst<String[]> containing the query type, the two vertices and the "?"
     * @param outputFileName a String containing the name of the file to be written to
     * @throws IOException
     */
    private static void query(LinkedList<String[]> queryList, String outputFileName) throws IOException {
        
    	OutputStream outputStream = new FileOutputStream(outputFileName);
        BufferedWriter outputWriter = new BufferedWriter (new OutputStreamWriter(outputStream));
        for(String[] stringArray: queryList) {
          
        	
            Vertex a = new Vertex(stringArray[1]);
            Vertex b = new Vertex(stringArray[2]);
            String test = stringArray[0];
            
            if(test.equals("commonInfluencers")) {
                ArrayList<Vertex> commonAB = (ArrayList<Vertex>) Algorithms.commonDownstreamVertices(twitter, a, b);
                String result = new String("Query: " + test + " " + a.getLabel() + " " + b.getLabel() );
                
                outputWriter.write(result);
                outputWriter.newLine();
                outputWriter.write("<result>");
                
                for(Vertex commonDown: commonAB) {
                	outputWriter.newLine();
                	outputWriter.write(commonDown.toString());
                	outputWriter.newLine();
                }
                
                outputWriter.write("\n</result>");
                outputWriter.newLine();
                
            }else if(test.equals("numRetweets")) {
            	
                Integer shortestDistance = Algorithms.shortestDistance(twitter, a, b);
                String result = new String("Query: " + test + " " + a.getLabel() + " " + b.getLabel() );
                
                outputWriter.write(result);
                outputWriter.newLine();
                outputWriter.write("<result>");
                outputWriter.newLine();
                if(shortestDistance == -1){
                	outputWriter.write("No path available");
                }else{
                	outputWriter.write(shortestDistance.toString());
                }
                
                outputWriter.newLine();
                outputWriter.write("</result>");
                outputWriter.newLine();
                outputWriter.newLine();
                
            }
        }outputWriter.close();
    }
    
    /**
     * 
     * @param outputFileName a String containing the name of the file to be written to
     * @param toWrite a String that is to be written to the output file
     * @throws IOException
     */
    private static void writer(String outputFileName, String toWrite) throws IOException {
        
    	OutputStream outputStream = new FileOutputStream(outputFileName);
        BufferedWriter outputWriter = new BufferedWriter (new OutputStreamWriter(outputStream));
        outputWriter.write(toWrite);
        outputWriter.close();
    }

}
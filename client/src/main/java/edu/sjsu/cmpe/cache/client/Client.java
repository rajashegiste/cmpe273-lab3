package edu.sjsu.cmpe.cache.client;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
public class Client {

    public static void main(String[] args) throws Exception {
    	final Funnel<CharSequence> strFunnel = Funnels.stringFunnel();
        HashFunction hf = Hashing.md5();
        System.out.println("Starting Cache Client...");
        String node1 = "http://localhost:3000";
        String node2 = "http://localhost:3001";
        String node3 = "http://localhost:3002";
        CacheServiceInterface cache1 = new DistributedCacheService(node1);
        CacheServiceInterface cache2 = new DistributedCacheService(node2);
        CacheServiceInterface cache3 = new DistributedCacheService(node3);
        
        
        //Part 1 : Consistent Hashing
        
        CacheServiceInterface[] buckets = {cache1, cache2, cache3};
 	    
 	    Map<Long, String> conHash =  new HashMap<Long, String>();
 	    conHash.put((long)1, "a");
 	    conHash.put((long)2, "b");
 	    conHash.put((long)3, "c");
 	    conHash.put((long)4, "d");
 	    conHash.put((long)5, "e");
 	    conHash.put((long)6, "f");
 	    conHash.put((long)7, "g");
 	    conHash.put((long)8, "h");
 	    conHash.put((long)9, "i");
 	    conHash.put((long)10, "j");
 	 

 	     
 	    for(long i=1; i<=dataMap.size(); i++){
 	    	int bucketNumber = ConsistentHash.getConsistentHash("md5", i, buckets.length);
 	    	buckets[bucketNumber].put(i, conHash.get(i));
 	    	System.out.println("put("+ i +"=>"+ conHash.get(i) +") @ http://localhost:300" + bucketNumber);
 	    	 
 	    }
 	    
 	    

 	    for(long i=1; i<=dataMap.size(); i++){
 	    	int bucketNumber = ConsistentHash.getConsistentHash("md5", i, buckets.length);
 	    	String value = buckets[bucketNumber].get(i);
 	    	System.out.println("get("+ i +") => "+ value + " @ http://localhost:300" + bucketNumber);
 	    }
        
        
        
        
        
        
        
        
        /*
         * 
         * 
         *Part 2 : Rendezous Hashing algorithm
        
        Map<Integer, String> hashObject = new HashMap<Integer, String>();
        hashObject.put(1, "a");
        hashObject.put(2, "b");
        hashObject.put(3, "c");
        hashObject.put(4, "d");
        hashObject.put(5, "e");
        hashObject.put(6, "f");
        hashObject.put(7, "g");
        hashObject.put(8, "h");
        hashObject.put(9, "i");
        hashObject.put(10, "j");
        List<String> al = new ArrayList<String>(); 
        al.add(node1);
        al.add(node2);
        al.add(node3);
        
        RendezvousHash hashAlgo = new RendezvousHash(hf, strFunnel, strFunnel, al);
        
        String obj1 =(String)hashAlgo.get("1");
        String obj2 =(String)hashAlgo.get("2");
        String obj3 =(String)hashAlgo.get("3");
        String obj4 =(String)hashAlgo.get("4");
        String obj5 =(String)hashAlgo.get("5");
        String obj6 =(String)hashAlgo.get("6");
        String obj7 =(String)hashAlgo.get("7");
        String obj8 =(String)hashAlgo.get("8");
        String obj9 =(String)hashAlgo.get("9");
        String obj10 =(String)hashAlgo.get("10");


        ArrayList<String> HashNode = new ArrayList<String>();
        HashNode.add(0, "");
        HashNode.add(1, objNode1);
        HashNode.add(2, objNode2);
        HashNode.add(3, objNode3);
        HashNode.add(4, objNode4);
        HashNode.add(5, objNode5);
        HashNode.add(6, objNode6);
        HashNode.add(7, objNode7);
        HashNode.add(8, objNode8);
        HashNode.add(9, objNode9);
        HashNode.add(10, objNode10);

        for(int i=1;i<=10;i++) {
        	System.out.println(HashNode.get(i)+" : "+i+" -> "+objects.get(i));
        }
        String node="";
        for(int i = 1;i<HashNode.size();i++) {
        	node = HashNode.get(i);
            if(node.equals(node1)) cache1.put(i, objects.get(i));
            else if(node.equals(node2)) cache2.put(i, objects.get(i));
            else if(node.equals(node3)) cache3.put(i, objects.get(i));
        }
        
        
        System.out.println("Existing Cache Client...");
    */
    }
    

}
        }
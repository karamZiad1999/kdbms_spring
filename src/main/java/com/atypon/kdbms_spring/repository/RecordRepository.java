package com.atypon.kdbms_spring.repository;



import com.atypon.kdbms_spring.domain.Payload;
import com.atypon.kdbms_spring.domain.Record;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

@Repository
public class RecordRepository {
    public Payload getQuery(String query){

        Socket socket = null;
        PrintWriter out = null;
        Scanner sc = null;
        String output;
        Payload payload = null;
        try{
            socket = new Socket("127.0.0.1", 2000);
            out = new PrintWriter(socket.getOutputStream(), true);
            sc = new Scanner(socket.getInputStream()).useDelimiter("end");

            out.println(query);

            output = sc.hasNext() ? sc.next() : " ";
            payload = new Payload(output);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                socket.close();
                out.close();
                sc.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return payload;
    }
}

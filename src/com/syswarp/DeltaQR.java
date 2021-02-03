/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syswarp;

/**
 *
 * @author riddick
 */
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DeltaQR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // para testear uso el dato de afip
        String json = "{\"ver\":1,\"fecha\":\"2020-10-13\",\"cuit\":30000000007,\"ptoVta\":10,\"tipoCmp\":1,\"nroCmp\":94,\"importe\":12100,\"moneda\":\"DOL\",\"ctz\":65,\"tipoDocRec\":80,\"nroDocRec\":20000000001,\"tipoCodAut\":\"E\",\"codAut\":70417054367476}";
        String salida = cifrarBase64(json);
        System.out.println(salida);
        //   eyJ2ZXIiOjEsImZlY2hhIjoiMjAyMC0xMC0xMyIsImN1aXQiOjMwMDAwMDAwMDA3LCJwdG9WdGEiOjEwLCJ0aXBvQ21wIjoxLCJucm9DbXAiOjk0LCJpbXBvcnRlIjoxMjEwMCwibW9uZWRhIjoiRE9MIiwiY3R6Ijo2NSwidGlwb0RvY1JlYyI6ODAsIm5yb0RvY1JlYyI6MjAwMDAwMDAwMDEsInRpcG9Db2RBdXQiOiJFIiwiY29kQXV0Ijo3MDQxNzA1NDM2NzQ3Nn0=
        // p=eyJ2ZXIiOjEsImZlY2hhIjoiMjAyMC0xMC0xMyIsImN1aXQiOjMwMDAwMDAwMDA3LCJwdG9WdGEiOjEwLCJ0aXBvQ21wIjoxLCJucm9DbXAiOjk0LCJpbXBvcnRlIjoxMjEwMCwibW9uZWRhIjoiRE9MIiwiY3R6Ijo2NSwidGlwb0RvY1JlYyI6ODAsIm5yb0RvY1JlYyI6MjAwMDAwMDAwMDEsInRpcG9Db2RBdXQiOiJFIiwiY29kQXV0Ijo3MDQxNzA1NDM2NzQ3Nn0=

 /*
      
        
        
select 
json_build_object(
   'ver', 1,
   'fecha', mc.fechamov::date,
   'cuit', cl.nrodocumento,-- aca va el cuit del emisor (se lo puedo clavar)
   'ptoVta', mc.sucursal,
   'tipoCmp',mc.tipomovs,    -- verificar esto
   'nroCmp', mc.comprob,
   'importe', mc.importe::numeric(18,2),
   'moneda', 'PES',         -- verificar esto
   'ctz', 1, -- cotizacion revisar
   'tipoDocRec',mc.tipomovs , --revisar esto
   'nroDocRec', cl.nrodocumento,
   'tipoCodAut','E',
   'codAut',mc.afipcae
   ) as json
from clientesmovcli mc
  inner join clientesclientes cl on (mc.cliente = cl.idcliente and mc.idempresa=cl.idempresa)
where nrointerno = 13345

        
        
        
        */
        
    }

    public static String cifrarBase64(String a) {
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8));
        return b;
    }

    public static String descifrarBase64(String a) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);

        String b = new String(decodedByteArray);
        return b;
    }

}

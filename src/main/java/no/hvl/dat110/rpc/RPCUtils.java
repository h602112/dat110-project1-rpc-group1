package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

    public static byte[] encapsulate(byte rpcid, byte[] payload) {

        byte[] rpcmsg = null;

        // TODO - START

        // Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format


        if (payload != null) {
            try {
                rpcmsg = new byte[payload.length + 1];
                rpcmsg[0] = rpcid;
                int j = 1;
                for (byte b : payload) {
                    rpcmsg[j] = b;
                    j++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return rpcmsg;


        // TODO - END


    }


    public static byte[] decapsulate(byte[] rpcmsg) {

        byte[] payload = null;

        // TODO - START

        // Decapsulate the rpcid and payload in a byte array according to the RPC message syntax

        if (rpcmsg != null) {
            try {
                payload = new byte[rpcmsg.length-1];
                for (int i = 0; i < payload.length; i++) {
                    payload[i] = rpcmsg[i+1];
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // TODO - END

        return payload;

    }

    // convert String to byte array
    public static byte[] marshallString(String str) {

        byte[] encoded = null;


        // TODO - START

        if (str != null) {
            try {
                encoded = str.getBytes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // TODO - END

        return encoded;
    }

    // convert byte array to a String
    public static String unmarshallString(byte[] data) {

        String decoded = null;

        // TODO - START

        if (data != null) {
            try {
                decoded = new String(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // TODO - END

        return decoded;
    }

    public static byte[] marshallVoid() {

        byte[] encoded = null;

        // TODO - START

        try {
            encoded = new byte[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO - END

        return encoded;

    }

    public static void unmarshallVoid(byte[] data) {

        // TODO

        if (data != null) {
            System.out.println("Data length: " + data.length);
        }
    }
    // convert boolean to a byte array representation
    public static byte[] marshallBoolean(boolean b) {

        byte[] encoded = new byte[1];

        if (b) {
            encoded[0] = 1;
        } else {
            encoded[0] = 0;
        }

        return encoded;
    }

    // convert byte array to a boolean representation
    public static boolean unmarshallBoolean(byte[] data) {

        return (data[0] > 0);

    }

    // integer to byte array representation
    public static byte[] marshallInteger(int x) {

        byte[] encoded = null;

        // TODO - START

        if (x != 0) {
            ByteBuffer bb =  ByteBuffer.allocate(4);
            bb.putInt(x);
            encoded = bb.array();
        }


        // TODO - END

        return encoded;
    }

    // byte array representation to integer
    public static int unmarshallInteger(byte[] data) {

        int decoded = 0;

        // TODO - START

        if (data != null) {
            for (byte b: data) {
                decoded = (decoded << 8) + (b & 0xFF);
            }

        }
        // TODO - END

        return decoded;

    }
}

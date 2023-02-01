package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

    public static final int SEGMENTSIZE = 128;

    public static int MESSAGINGPORT = 8080;
    public static String MESSAGINGHOST = "localhost";

    public static byte[] encapsulate(Message message) {

        byte[] segment = null;
        byte[] data;

        // TODO - START

        // encapulate/encode the payload data of the message and form a segment
        // according to the segment format for the messaging layer

        if (message != null) {
            data = message.getData();
            int dataLength = message.getData().length;
            segment = new byte[128];
            segment[0] = (byte) dataLength;
            int j = 1;
            for (int i = 0; i < dataLength; i++) {
                segment[j] = data[i];
                j++;
            }



            // TODO - END
        }
        return segment;
    }


    public static Message decapsulate(byte[] segment) {

        Message message = null;

        // TODO - START
        // decapsulate segment and put received payload data into a message

        if (segment.length != 0) {
            int messageLength = segment[0];
            byte[] data = new byte[messageLength];
            int j = 1;
            for (int i = 0; i < messageLength; i++) {
                data[i] = segment[j];
                j++;
            }
            message = new Message(data);


            // TODO - END
        }

        return message;

    }
}
	


package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		// TODO - START
		
		// implement marshalling, call and unmarshalling for write RPC method


		
		if (message != null) {
			RPCUtils.marshallString(message);
			rpcclient.call((byte) Common.WRITE_RPCID, RPCUtils.marshallString(message));
			RPCUtils.unmarshallString(RPCUtils.marshallString(message));
		}

		
		// TODO - END
		
	}
}

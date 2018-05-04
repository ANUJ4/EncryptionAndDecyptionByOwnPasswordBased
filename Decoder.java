package com.akt.security.use;

public interface Decoder {
	Object decode(Object source) throws DecoderException;
}

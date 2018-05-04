package com.akt.security.use;

public interface Encoder {

	Object encode(Object source) throws EncoderException;
}

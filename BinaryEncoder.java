package com.akt.security.use;

public interface BinaryEncoder extends Encoder {
	byte[] encode(byte[] source) throws EncoderException;
}

package com.akt.security.use;

public interface BinaryDecoder extends Decoder {
	byte[] decode(byte[] source) throws DecoderException;
}

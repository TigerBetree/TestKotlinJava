package com.test.aes;

public final class GFBase64 {
    private static final int BASELENGTH = 128;
    private static final int LOOKUPLENGTH = 64;
    private static final int TWENTYFOURBITGROUP = 24;
    private static final int EIGHTBIT = 8;
    private static final int SIXTEENBIT = 16;
    private static final int FOURBYTE = 4;
    private static final int SIGN = -128;
    private static final char PAD = '=';
    private static byte[] base64Alphabet = new byte[128];
    private static char[] lookUpBase64Alphabet = new char[64];

    public GFBase64() {
    }

    private static boolean isWhiteSpace(char var0) {
        return var0 == ' ' || var0 == '\r' || var0 == '\n' || var0 == '\t';
    }

    private static boolean isPad(char var0, char... var1) {
        if (var1 != null && var1.length != 0) {
            char[] var3 = var1;
            int var4 = var1.length;

            for(int var2 = 0; var2 < var4; ++var2) {
                if (var3[var2] != '=') {
                    return false;
                }
            }

            return true;
        } else {
            return var0 == '=';
        }
    }

    private static boolean isData(char var0, char... var1) {
        if (var1 != null && var1.length != 0) {
            char[] var4 = var1;
            int var5 = var1.length;

            for(int var2 = 0; var2 < var5; ++var2) {
                char var3;
                if ((var3 = var4[var2]) >= 128 || base64Alphabet[var3] == -1) {
                    return false;
                }
            }

            return true;
        } else {
            return var0 < 128 && base64Alphabet[var0] != -1;
        }
    }

    public static String encode(byte[] var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1;
            if ((var1 = var0.length * 8) == 0) {
                return "";
            } else {
                int var2 = var1 % 24;
                var1 /= 24;
                char[] var3 = new char[(var2 != 0 ? var1 + 1 : var1) * 4];
                int var9 = 0;
                int var10 = 0;

                byte var4;
                byte var5;
                byte var6;
                byte var7;
                for(int var11 = 0; var11 < var1; ++var11) {
                    var6 = var0[var10++];
                    var7 = var0[var10++];
                    byte var8 = var0[var10++];
                    var5 = (byte)(var7 & 15);
                    var4 = (byte)(var6 & 3);
                    var6 = (var6 & -128) == 0 ? (byte)(var6 >> 2) : (byte)(var6 >> 2 ^ 192);
                    var7 = (var7 & -128) == 0 ? (byte)(var7 >> 4) : (byte)(var7 >> 4 ^ 240);
                    byte var12 = (var8 & -128) == 0 ? (byte)(var8 >> 6) : (byte)(var8 >> 6 ^ 252);
                    var3[var9++] = lookUpBase64Alphabet[var6];
                    var3[var9++] = lookUpBase64Alphabet[var7 | var4 << 4];
                    var3[var9++] = lookUpBase64Alphabet[var5 << 2 | var12];
                    var3[var9++] = lookUpBase64Alphabet[var8 & 63];
                }

                byte var13;
                if (var2 == 8) {
                    var4 = (byte)((var6 = var0[var10]) & 3);
                    var13 = (var6 & -128) == 0 ? (byte)(var6 >> 2) : (byte)(var6 >> 2 ^ 192);
                    var3[var9++] = lookUpBase64Alphabet[var13];
                    var3[var9++] = lookUpBase64Alphabet[var4 << 4];
                    var3[var9++] = '=';
                    var3[var9] = '=';
                } else if (var2 == 16) {
                    var6 = var0[var10];
                    var5 = (byte)((var7 = var0[var10 + 1]) & 15);
                    var4 = (byte)(var6 & 3);
                    var13 = (var6 & -128) == 0 ? (byte)(var6 >> 2) : (byte)(var6 >> 2 ^ 192);
                    var6 = (var7 & -128) == 0 ? (byte)(var7 >> 4) : (byte)(var7 >> 4 ^ 240);
                    var3[var9++] = lookUpBase64Alphabet[var13];
                    var3[var9++] = lookUpBase64Alphabet[var6 | var4 << 4];
                    var3[var9++] = lookUpBase64Alphabet[var5 << 2];
                    var3[var9] = '=';
                }

                return new String(var3);
            }
        }
    }

    public static byte[] decode(String var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1;
            char[] var10;
            if ((var1 = removeWhiteSpace(var10 = var0.toCharArray())) % 4 != 0) {
                return null;
            } else if ((var1 /= 4) == 0) {
                return new byte[0];
            } else {
                int var7 = 0;
                int var8 = 0;
                int var9 = 0;

                byte[] var2;
                char var3;
                char var4;
                char var5;
                char var6;
                byte var12;
                byte var13;
                byte var14;
                byte var15;
                for(var2 = new byte[var1 * 3]; var7 < var1 - 1; ++var7) {
                    if (!isData(var3 = var10[var9++], var4 = var10[var9++], var5 = var10[var9++], var6 = var10[var9++])) {
                        return null;
                    }

                    var12 = base64Alphabet[var3];
                    var13 = base64Alphabet[var4];
                    var14 = base64Alphabet[var5];
                    var15 = base64Alphabet[var6];
                    var2[var8++] = (byte)(var12 << 2 | var13 >> 4);
                    var2[var8++] = (byte)((var13 & 15) << 4 | var14 >> 2 & 15);
                    var2[var8++] = (byte)(var14 << 6 | var15);
                }

                if (!isData(var3 = var10[var9++], var4 = var10[var9++])) {
                    return null;
                } else {
                    var12 = base64Alphabet[var3];
                    var13 = base64Alphabet[var4];
                    var5 = var10[var9++];
                    var6 = var10[var9];
                    if (!isData(var5, var6)) {
                        byte[] var11;
                        if (isPad(var5, var6)) {
                            if ((var13 & 15) != 0) {
                                return null;
                            } else {
                                var11 = new byte[var7 * 3 + 1];
                                System.arraycopy(var2, 0, var11, 0, var7 * 3);
                                var11[var8] = (byte)(var12 << 2 | var13 >> 4);
                                return var11;
                            }
                        } else if (!isPad(var5) && isPad(var6)) {
                            if (((var14 = base64Alphabet[var5]) & 3) != 0) {
                                return null;
                            } else {
                                var11 = new byte[var7 * 3 + 2];
                                System.arraycopy(var2, 0, var11, 0, var7 * 3);
                                var11[var8++] = (byte)(var12 << 2 | var13 >> 4);
                                var11[var8] = (byte)((var13 & 15) << 4 | var14 >> 2 & 15);
                                return var11;
                            }
                        } else {
                            return null;
                        }
                    } else {
                        var14 = base64Alphabet[var5];
                        var15 = base64Alphabet[var6];
                        var2[var8++] = (byte)(var12 << 2 | var13 >> 4);
                        var2[var8++] = (byte)((var13 & 15) << 4 | var14 >> 2 & 15);
                        var2[var8] = (byte)(var14 << 6 | var15);
                        return var2;
                    }
                }
            }
        }
    }

    private static int removeWhiteSpace(char[] var0) {
        if (var0 == null) {
            return 0;
        } else {
            int var1 = 0;
            int var2 = var0.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                if (!isWhiteSpace(var0[var3])) {
                    var0[var1++] = var0[var3];
                }
            }

            return var1;
        }
    }

    static {
        int var0;
        for(var0 = 0; var0 < 128; ++var0) {
            base64Alphabet[var0] = -1;
        }

        for(var0 = 90; var0 >= 65; --var0) {
            base64Alphabet[var0] = (byte)(var0 - 65);
        }

        for(var0 = 122; var0 >= 97; --var0) {
            base64Alphabet[var0] = (byte)(var0 - 97 + 26);
        }

        for(var0 = 57; var0 >= 48; --var0) {
            base64Alphabet[var0] = (byte)(var0 - 48 + 52);
        }

        base64Alphabet[43] = 62;
        base64Alphabet[47] = 63;

        for(var0 = 0; var0 <= 25; ++var0) {
            lookUpBase64Alphabet[var0] = (char)(65 + var0);
        }

        var0 = 26;

        int var1;
        for(var1 = 0; var0 <= 51; ++var1) {
            lookUpBase64Alphabet[var0] = (char)(97 + var1);
            ++var0;
        }

        var0 = 52;

        for(var1 = 0; var0 <= 61; ++var1) {
            lookUpBase64Alphabet[var0] = (char)(48 + var1);
            ++var0;
        }

        lookUpBase64Alphabet[62] = '+';
        lookUpBase64Alphabet[63] = '/';
    }
}
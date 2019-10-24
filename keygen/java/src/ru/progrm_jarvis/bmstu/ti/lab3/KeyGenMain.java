package ru.progrm_jarvis.bmstu.ti.lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class KeyGenMain {
    private static final int REQUIRED = 0x100, MIN = 0x21, MAX = 0x80;

    public static void main(String[] args) {
        String username;
        out.println("Insert wanted username:");
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            do {
                username = reader.readLine();
            } while (username == null || username.isEmpty());
        } catch (final IOException e) {
            throw new RuntimeException("An exception occurred while trying to read console input", e);
        }

        int usernameHash = username.charAt(username.length() - 1) << 24 >> 24;
        usernameHash = (usernameHash + usernameHash + 0x17) & 0x8000007F;
        if (usernameHash >>> 31 == 1) usernameHash = ((usernameHash - 1) | 0xFFFFFF80) + 1;
        usernameHash = usernameHash & 0xFF;

        String result = null;
        loop:
        {
            for (int char1 = MIN; char1 < MAX; char1++) {
                final int char1hash = (char1 << 24 >> 24) ^ usernameHash;
                for (int char2 = MIN; char2 < MAX; char2++) {
                    final int char2hash = (char2 << 24 >> 24) ^ usernameHash;
                    for (int char3 = MIN; char3 < MAX; char3++) {
                        final int char3hash = (char3 << 24 >> 24) ^ usernameHash;
                        for (int char4 = MIN; char4 < MAX; char4++) {
                            final int char4hash = (char4 << 24 >> 24) ^ usernameHash;
                            for (int char5 = MIN; char5 < MAX; char5++) {
                                final int char5hash = (char5 << 24 >> 24) ^ usernameHash;
                                for (int char6 = MIN; char6 < MAX; char6++) {
                                    final int char6hash = (char6 << 24 >> 24) ^ usernameHash;
                                    for (int char7 = MIN; char7 < MAX; char7++) {
                                        final int char7hash = (char7 << 24 >> 24) ^ usernameHash;
                                        for (int char8 = MIN; char8 < MAX; char8++) {
                                            final int char8hash = (char8 << 24 >> 24) ^ usernameHash;
                                            for (int char9 = MIN; char9 < MAX; char9++) {
                                                final int char9hash = (char9 << 24 >> 24) ^ usernameHash;
                                                for (int char10 = MIN; char10 < MAX; char10++) {
                                                    final int char10hash = (char10 << 24 >> 24) ^ usernameHash;
                                                    for (int char11 = MIN; char11 < MAX; char11++) {
                                                        final int char11hash = (char11 << 24 >> 24) ^ usernameHash;
                                                        for (int char12 = MIN; char12 < MAX; char12++) {
                                                            final int char12hash = (char12 << 24 >> 24) ^ usernameHash;
                                                            if (char1hash + char2hash + char3hash + char4hash
                                                                    + char5hash + char6hash + char7hash + char8hash
                                                                    + char9hash + char10hash + char11hash + char12hash
                                                                    == REQUIRED) {
                                                                result = ""
                                                                        + (char) char1
                                                                        + (char) char2
                                                                        + (char) char3
                                                                        + (char) char4
                                                                        + '-'
                                                                        + (char) char5
                                                                        + (char) char6
                                                                        + (char) char7
                                                                        + (char) char8
                                                                        + '-'
                                                                        + (char) char9
                                                                        + (char) char10
                                                                        + (char) char11
                                                                        + (char) char12;
                                                                break loop;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(result == null
                ? "Could not generate password for you, so sorry" : "Generated password: `" + result + '`');
    }
}
package edu.citytech.cst.s23253396.merged_apps.abc_counter.services;

import com.jbbwebsolutions.http.utility.JSONGet;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbcCounterServiceJsonImpl implements AbcCounterService {

    private final String ABC_SERVICE_URL = "http://localhost:8080/api/v1";
    private final String MODE_ABC = this.ABC_SERVICE_URL + "/mode/abc";
    private final String MODE_CBA = this.ABC_SERVICE_URL + "/mode/cba";
    private final String MODE_AaBbCc = this.ABC_SERVICE_URL + "/mode/AaBbCc";
    private final String MODE_123 = this.ABC_SERVICE_URL + "/mode/123";
    private final String MODE_321 = this.ABC_SERVICE_URL + "/mode/321";
    private final String MODE_369 = this.ABC_SERVICE_URL + "/mode/369";
    private final String IS_VOWEL = this.ABC_SERVICE_URL + "/isVowel/";
    private final String IS_VOWEL_AaBbCc = this.ABC_SERVICE_URL + "/isVowelAaBbCc/";
    private final String IS_CONSONANT = this.ABC_SERVICE_URL + "/isConsonant/";
    private final String IS_CONSONANT_AaBbCc = this.ABC_SERVICE_URL + "/isConsonantAaBbCc/";
    private final String IS_EVEN = this.ABC_SERVICE_URL + "/isEven/";
    private final String IS_ODD = this.ABC_SERVICE_URL + "/isOdd/";
    private final String IS_DIVISIBLE_BY_6 = this.ABC_SERVICE_URL + "/isDivisibleBy6/";
    private final String CONTAINS_7 = this.ABC_SERVICE_URL + "/contains7/";

    @Override
    public List<Character> countABC() {
        if (this.getConnection()) {
            return Arrays.asList(JSONGet.submitGet(this.MODE_ABC, Character[].class));
        }

        return new ArrayList<>();
    }

    @Override
    public List<Character> countCBA() {
        if (this.getConnection()) {
            return Arrays.asList(JSONGet.submitGet(this.MODE_CBA, Character[].class));
        }

        return new ArrayList<>();
    }

    @Override
    public List<String> countAaBbCc() {
        if (this.getConnection()) {
            return Arrays.asList(JSONGet.submitGet(this.MODE_AaBbCc, String[].class));
        }

        return new ArrayList<>();
    }

    @Override
    public List<Integer> count123() {
        if (this.getConnection()) {
            return Arrays.asList(JSONGet.submitGet(this.MODE_123, Integer[].class));
        }

        return new ArrayList<>();
    }

    @Override
    public List<Integer> count321() {
        if (this.getConnection()) {
            return Arrays.asList(JSONGet.submitGet(this.MODE_321, Integer[].class));
        }

        return new ArrayList<>();
    }

    @Override
    public List<Integer> count369() {
        if (this.getConnection()) {
            return Arrays.asList(JSONGet.submitGet(this.MODE_369, Integer[].class));
        }

        return new ArrayList<>();
    }

    @Override
    public boolean isVowel(String string) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_VOWEL + string, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.IS_VOWEL + " not available!");
    }

    @Override
    public boolean isVowelAaBbCc(String string) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_VOWEL_AaBbCc + string, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.IS_VOWEL_AaBbCc + " not available!");
    }

    @Override
    public boolean isConsonant(String string) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_CONSONANT + string, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.IS_CONSONANT + " not available!");
    }

    @Override
    public boolean isConsonantAaBbCc(String string) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_CONSONANT_AaBbCc + string, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.IS_CONSONANT_AaBbCc + " not available!");
    }

    @Override
    public boolean isEven(int integer) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_EVEN + integer, boolean.class);
        }


        throw new RuntimeException("Connection for: " + this.IS_EVEN + " not available!");
    }

    @Override
    public boolean isOdd(int integer) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_ODD + integer, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.IS_ODD + " not available!");
    }

    @Override
    public boolean isDivisibleBy6(int integer) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.IS_DIVISIBLE_BY_6 + integer, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.IS_DIVISIBLE_BY_6 + " not available!");
    }

    @Override
    public boolean contains7(int integer) {
        if (this.getConnection()) {
            return JSONGet.submitGet(this.CONTAINS_7 + integer, boolean.class);
        }

        throw new RuntimeException("Connection for: " + this.CONTAINS_7 + " not available!");
    }

    private boolean getConnection() {
        try {
            Socket socket = new Socket("localhost", 8080);
            return true;
        } catch (ConnectException | UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}

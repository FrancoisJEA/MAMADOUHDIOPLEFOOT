package com.footaddict.superstars.footaddict;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListLeague {
        private static List<League> lleague;

        @JsonProperty("league")
        public static List<League> getLeague ()
        {
            return lleague;
        }

        public static void setLeague (List<League> league)
        {
            lleague = league;
        }

        @Override
        public String toString()
        {
            return "[league = "+lleague+"]";
        }
}
package com.footaddict.superstars.footaddict;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListLeague {
        private League[] league;

        @JsonProperty("league")
        public League[] getLeague ()
        {
            return league;
        }

        public void setLeague (League[] league)
        {
            this.league = league;
        }

        @Override
        public String toString()
        {
            return "[league = "+league+"]";
        }
}
package nyc.c4q.mustafizurmatin.pokemon.models;

/**
 * Created by c4q on 2/9/18.
 */

public class Results {

        /**
         * url : https://pokeapi.co/api/v2/pokemon/1/
         * name : bulbasaur
         */
        private int number;
        private String url;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public int getNumber() {
            String [] urlSplit = url.split("/");
        return Integer.parseInt(urlSplit[urlSplit.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


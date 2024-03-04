package com.company.project.lesson11;
// Country.UK.setPopulation(4374103)
public enum Country {
    USA("usa", 43875248){
        @Override
        public void printInfo() {
            System.out.println("USA");
        }
        public void usaVoid(){}
    },
    UK("uk", 4254524){
        @Override
        public void printInfo() {
            System.out.println("UK");
        }
    },
    BRAZIL("brazil", 582098204) {
        @Override
        public void printInfo() {
            System.out.println("BRAZIL");
        }
    };

    private String title;
    private long population;

    /* private */ Country(String title, long population) {
        this.title = title;
        this.population = population;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    abstract public void printInfo();
}

// enum планеты солнечной системы (от 3 шт.)
// название
// масса
// радиус

// перебрать в цикле, вывести всю информацию в консоль
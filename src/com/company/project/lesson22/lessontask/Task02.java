package com.company.project.lesson22.lessontask;

public class Task02 {
    public static void main(String[] args) {
        // Датчик может информировать о
        // повышении или понижении температуры
        // Когда в датчике меняется температура (Math.random())
        // экземпляры red, yellow и green реагируют
        // на данные изменения, каждый своим способом (sout)

        // red начинает реагировать на повышении температуры,
        // начиная с 300С, далее каждые 50С

        // yellow начинает реагировать на повышении температуры,
        // начиная с 200С, далее каждые 30С

        // green начинает реагировать на повышении температуры,
        // начиная с 100С, далее каждые 10С

        Reactionable red = new Reactionable() {
            @Override
            public void react(double value) {}
            @Override
            public void log() {}
        };
        Reactionable green = new Reactionable() {
            @Override
            public void react(double value) {}
            @Override
            public void log() {}
        };

    }
}

package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    private AfishaManager manager = new AfishaManager();
    private AfishaManager manager1 = new AfishaManager(5);
    private AfishaManager manager2 = new AfishaManager(0);

    private Movie item1 = new Movie(1, "Casper", "comedy");
    private Movie item2 = new Movie(2, "Proposal", "comedy");
    private Movie item3 = new Movie(3, "The Simpsons", "cartoon");
    private Movie item4 = new Movie(4, "Soul", "cartoon");
    private Movie item5 = new Movie(5, "Doctor Strange", "fantasy");
    private Movie item6 = new Movie(6, "Friends", "comedy");
    private Movie item7 = new Movie(7, "Knives Out", "detective");
    private Movie item8 = new Movie(8, "John Wick", "action");
    private Movie item9 = new Movie(9, "The Gentlemen", "action");
    private Movie item10 = new Movie(10, "The Watch", "fantasy");
    private Movie item11 = new Movie(11, "Venom", "action");

    @BeforeEach
    @Test
    void setManagerUp() {
        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);
        manager.addMovie(item8);
        manager.addMovie(item9);
    }

    @Test
    void setManager1Up() {
        manager1.addMovie(item1);
        manager1.addMovie(item2);
        manager1.addMovie(item3);
        manager1.addMovie(item4);
    }

    @Test
    public void showAfishaLessDefaultLength() {
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{item9, item8, item7, item6, item5, item4, item3, item2, item1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaWithDefaultLength() {
        manager.addMovie(item10);
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaMoreDefaultLength() {
        manager.addMovie(item10);
        manager.addMovie(item11);
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void showMoreMovieFromList() {
        manager1.addMovie(item1);
        manager1.addMovie(item2);
        manager1.addMovie(item3);
        manager1.addMovie(item4);
        manager1.addMovie(item5);
        manager1.addMovie(item6);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{item6, item5, item4, item3, item2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void showMovieFromList() {
        manager1.addMovie(item1);
        manager1.addMovie(item2);
        manager1.addMovie(item3);
        manager1.addMovie(item4);
        manager1.addMovie(item5);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{item5, item4, item3, item2, item1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void showNothing() {
        Movie[] actual = manager2.getLastMovieAdded();
        Movie[] expected = {};
        assertArrayEquals(actual, expected);
    }
}
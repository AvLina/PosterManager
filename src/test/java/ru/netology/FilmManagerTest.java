package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {


        @Test
        public void addTest() {

            FilmManager manager = new FilmManager();

            Film one = new Film(1, "Мальчишник в Вегасе", "url1", "comedy");
            Film two = new Film(2, "Дюна", "url2", "fantasy");
            Film three = new Film(3, "Сумерки", "url3", "fantasy");
            Film four = new Film(4, "Отряд самоубийц", "url4", "thriller");
            Film five = new Film(5, "Черный лебедь", "url5", "drama");
            Film six = new Film(6, "Зеленая миля", "url6", "drama");
            Film seven = new Film(7, "Иван Васильевич меняет профессию", "url7", "comedy");
            Film eight = new Film(8, "Криминальное чтиво", "url8", "drama");
            Film nine = new Film(9, "Джентельмены", "url9", "comedy");
            Film ten = new Film(10, "Брат", "url10", "drama");
            Film eleven = new Film(11, "Один дома", "url", "comedy");


            manager.save(one);
            manager.save(two);
            manager.save(three);
            manager.save(four);
            manager.save(five);
            manager.save(six);
            manager.save(seven);
            manager.save(eight);
            manager.save(nine);
            manager.save(ten);
            manager.save(eleven);

            Film[] expected = {one, two, three, four, five, six, seven, eight, nine, ten, eleven};
            Film[] actual = manager.getFilms();

            assertArrayEquals(expected, actual);

        }

        @Test
        public void getLastFilmIfMoreThanTen() {
            FilmManager manager = new FilmManager();
            Film eleven = new Film(11, "Один дома", "url", "comedy");
            Film ten = new Film(10, "Брат", "url10", "drama");
            Film nine = new Film(9, "Джентельмены", "url9", "comedy");
            Film eight = new Film(8, "Криминальное чтиво", "url8", "drama");
            Film seven = new Film(7, "Иван Васильевич меняет профессию", "url7", "comedy");
            Film six = new Film(6, "Зеленая миля", "url6", "drama");
            Film five = new Film(5, "Черный лебедь", "url5", "drama");
            Film four = new Film(4, "Отряд самоубийц", "url4", "thriller");
            Film three = new Film(3, "Сумерки", "url3", "fantasy");
            Film two = new Film(2, "Дюна", "url2", "fantasy");
            Film one = new Film(1, "Мальчишник в Вегасе", "url1", "comedy");

            manager.save(eleven);
            manager.save(ten);
            manager.save(nine);
            manager.save(eight);
            manager.save(seven);
            manager.save(six);
            manager.save(five);
            manager.save(four);
            manager.save(three);
            manager.save(two);
            manager.save(one);

            Film[] expected = {one, two, three, four, five, six, seven, eight, nine, ten};
            Film[] actual = manager.getLastFilm();

            assertArrayEquals(expected, actual);

        }

        @Test
        public void getLastFilmIfLessThanTen() {
            FilmManager manager = new FilmManager();

            Film six = new Film(6, "Зеленая миля", "url6", "drama");
            Film five = new Film(9, "Джентельмены", "url9", "comedy");
            Film four = new Film(10, "Брат", "url10", "drama");
            Film three = new Film(5, "Черный лебедь", "url5", "drama");
            Film two = new Film(1, "Мальчишник в Вегасе", "url1", "comedy");
            Film one = new Film(4, "Отряд самоубийц", "url4", "thriller");

            manager.save(six);
            manager.save(five);
            manager.save(four);
            manager.save(three);
            manager.save(two);
            manager.save(one);

            Film[] expected = {one, two, three, four, five, six};
            Film[] actual = manager.getLastFilm();

            assertArrayEquals(expected, actual);

        }

        @Test
        public void getLastFilmRandomAmount() {
            FilmManager manager = new FilmManager(8);
            Film eleven = new Film(6, "Зеленая миля", "url6", "drama");
            Film ten = new Film(7, "Иван Васильевич меняет профессию", "url7", "comedy");
            Film nine = new Film(11, "Один дома", "url", "comedy");
            Film eight = new Film(3, "Сумерки", "url3", "fantasy");
            Film seven = new Film(2, "Дюна", "url2", "fantasy");
            Film six = new Film(10, "Брат", "url10", "drama");
            Film five = new Film(9, "Джентельмены", "url9", "comedy");
            Film four = new Film(1, "Мальчишник в Вегасе", "url1", "comedy");
            Film three = new Film(5, "Черный лебедь", "url5", "drama");
            Film two = new Film(4, "Отряд самоубийц", "url4", "thriller");
            Film one = new Film(8, "Криминальное чтиво", "url8", "drama");

            manager.save(eleven);
            manager.save(ten);
            manager.save(nine);
            manager.save(eight);
            manager.save(seven);
            manager.save(six);
            manager.save(five);
            manager.save(four);
            manager.save(three);
            manager.save(two);
            manager.save(one);

            Film[] expected = {one, two, three, four, five, six, seven, eight};
            Film[] actual = manager.getLastFilm();

            assertArrayEquals(expected, actual);

        }


    }

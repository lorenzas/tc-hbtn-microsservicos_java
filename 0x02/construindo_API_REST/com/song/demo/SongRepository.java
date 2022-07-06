package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        Song song = getSongById(s.id);
        Collections.replaceAll(list, song, s);
    }

    public void removeSong(Song s) {
        list.remove(s);
    }
}
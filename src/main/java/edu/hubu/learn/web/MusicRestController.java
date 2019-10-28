package edu.hubu.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hubu.learn.entity.Result;
import edu.hubu.learn.entity.Music;
import edu.hubu.learn.service.MusicService;

@RestController

@RequestMapping("/rest/music")
public class MusicRestController {

    @Autowired
    private MusicService musicService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getById(@PathVariable("id") long id) {
        return musicService.getMusic(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAll() {
        return musicService.getMusics();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object addMusic(@RequestBody Music music) {
        musicService.addMusic(music);
        return music;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object modifyMusic(@RequestBody Music music) {
        musicService.modifyMusic(music);
        return music;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteMusic(@PathVariable("id") long id) {
        try {
            musicService.deleteMusic(id);
        } catch (Exception e) {
            return new Result(false, e);
        }
        return new Result(true, null);
    }

    @RequestMapping(value = "/search/{key}", method = RequestMethod.GET)
    public Object searchMusic(String key) {
        return musicService.searchMusics(key);
    }
} 
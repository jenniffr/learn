package edu.hubu.learn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.User;
import edu.hubu.learn.entity.Music;
import edu.hubu.learn.service.MusicService;
import edu.hubu.learn.service.UserService;

@Controller
@RequestMapping("/")
public class MusicController {


    @Autowired
    private MusicService musicService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }


    
    @RequestMapping("/music")
    public ModelAndView music() {
        ModelAndView mav = new ModelAndView();
        Music music = musicService.getMusic(1l);
        mav.addObject("music", music);
        mav.setViewName("music");
        return mav;
    }

    @RequestMapping("/music/{id}")
    public ModelAndView getmusic(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        Music music = musicService.getMusic(id);
        mav.addObject("music", music);
        mav.setViewName("music");
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView musics() {
        ModelAndView mav = new ModelAndView();
		List<Music> musics = musicService.getMusics();
        mav.addObject("musics", musics);
        mav.setViewName("musics");
        return mav;
    }
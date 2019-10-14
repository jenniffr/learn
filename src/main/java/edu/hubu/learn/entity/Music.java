package edu.hubu.learn.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "music")
@Data
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String musicname;

    private String singer;

	public void setAvatar(String string) {
    }
    
    @Column(name="avatar_url")
    private String avatar;
}
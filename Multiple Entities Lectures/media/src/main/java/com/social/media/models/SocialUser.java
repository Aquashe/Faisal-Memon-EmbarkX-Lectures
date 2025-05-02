package com.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user" , cascade = {CascadeType.REMOVE ,CascadeType.PERSIST , CascadeType.MERGE})
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser")
    private List<Posts> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    //We are explicitily setting the user into social profile
    public void setSocialProfile(SocialProfile socialProfile){
        socialProfile.setUser(this);
        this.socialProfile = socialProfile;
    }
}

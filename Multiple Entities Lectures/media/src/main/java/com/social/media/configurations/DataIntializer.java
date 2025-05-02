package com.social.media.configurations;

import com.social.media.models.Posts;
import com.social.media.models.SocialGroup;
import com.social.media.models.SocialProfile;
import com.social.media.models.SocialUser;
import com.social.media.repositories.PostsRepository;
import com.social.media.repositories.SocialGroupRepository;
import com.social.media.repositories.SocialProfileRepository;
import com.social.media.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataIntializer {

    @Autowired
    private  SocialUserRepository socialUserRepository;
    @Autowired
    private  SocialGroupRepository socialGroupRepository;
    @Autowired
    private  SocialProfileRepository socialProfileRepository;
    @Autowired
    private  PostsRepository postsRepository;


    @Bean
    public CommandLineRunner intializeData(){
        return  args -> {
            // 1. Create Some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            // 2. Create Some Groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            //associate groups with users
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);

            user2.getGroups().add(group2);
            user3.getGroups().add(group2);


            //we need to save users back to the DB for association
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);




            // 3. Create Some Posts

            Posts post1 = new Posts();
            Posts post2 = new Posts();
            Posts post3 = new Posts();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            postsRepository.save(post1);
            postsRepository.save(post2);
            postsRepository.save(post3);


            // 4. Crete some Social Profile

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();


            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

        };
    }
}

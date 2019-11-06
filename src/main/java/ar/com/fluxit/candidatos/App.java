package ar.com.fluxit.candidatos;

import ar.com.fluxit.candidatos.entity.Role;
import ar.com.fluxit.candidatos.entity.UserEntity;
import ar.com.fluxit.candidatos.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pablo on 2/11/2019.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableAutoConfiguration
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        /*Para fines de testeo*/
        Long time = new Date().getTime() * 1000;

        String token = Jwts.builder().setClaims(new HashMap<>())
                .setSubject("pablo.ocanto")
                .setExpiration(new Timestamp(time)).signWith(SignatureAlgorithm.HS512, "javainuse").compact();
        System.out.println(token);



        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("pablo.ocanto");
        userEntity.setPassowrd(new BCryptPasswordEncoder().encode("123456"));

        Role role = new Role();
        role.setName("USER");
        Set roles = new HashSet();
        userEntity.setRoles(roles);

        userRepository.save(userEntity);



    }
}

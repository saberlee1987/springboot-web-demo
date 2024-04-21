package com.saber.springbootwebdemo;

import com.saber.springbootwebdemo.controllers.ChallengeAttemptController;
import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.domains.user.query.User;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ChallengeAttemptController.class)
public class ChallengeAttemptControllerTest {
    @MockBean
    private ChallengeService challengeService;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<ChallengeAttemptDto> requestAttemptJson;
    @Autowired
    private JacksonTester<ChallengeAttempt> responseAttemptJson;

    @Test
    public void postValidTest() throws Exception {
        long attemptId = 5L;
        User user = new User(12L, "saber66");
        ChallengeAttemptDto requestChallenge = new ChallengeAttemptDto(
                50, 70, user.getAlias(), 3500
        );

        ChallengeAttempt responseChallenge = new ChallengeAttempt(
                attemptId, user
                , 50, 70, 3500
                , true
        );

        BDDMockito.given(challengeService.verifyAttempt(
                ArgumentMatchers.eq(requestChallenge))
        ).willReturn(responseChallenge);
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/attempts")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestAttemptJson.write(requestChallenge).getJson()))
                .andReturn().getResponse();
        BDDAssertions.then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        BDDAssertions.then(response.getContentAsString()).isEqualTo(
                responseAttemptJson.write(responseChallenge).getJson()
        );
    }

    @Test
    public void postInValidTest() throws Exception {
       // long attemptId = 5L;
        User user = new User(12L, "saber66");
        ChallengeAttemptDto requestChallenge = new ChallengeAttemptDto(
                2000, -70, user.getAlias(), 1
        );
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/attempts")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestAttemptJson.write(requestChallenge).getJson()))
                .andReturn().getResponse();
        BDDAssertions.then(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

}

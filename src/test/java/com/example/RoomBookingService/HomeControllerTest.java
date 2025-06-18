package com.example.RoomBookingService;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.context.annotation.Import;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.hamcrest.Matchers.containsString;
// import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

// import com.example.RoomBookingService.config.SecurityConfig;
// import com.example.RoomBookingService.controller.AuthController;
// import com.example.RoomBookingService.controller.HomeController;
// import com.example.RoomBookingService.service.TokenService;
// import com.example.RoomBookingService.service.LoginService;
// import com.example.RoomBookingService.service.UserService;
// import com.example.RoomBookingService.repository.UserRepository;

// @WebMvcTest({ HomeController.class, AuthController.class })
// @Import({ SecurityConfig.class, TokenService.class, LoginService.class, UserService.class })
class HomeControllerTest {

  // @Autowired
  // private MockMvc mockMvc;

  // @MockBean
  // private UserRepository userRepository;

  // @Test
  // void rootWhenUnauthenticatedThen401() throws Exception {
  //   this.mockMvc.perform(get("/admin"))
  //       .andExpect(status().isUnauthorized());
  // }

  // @Test
  // void rootWhenAuthenticatedThenSaysHelloUser() throws Exception {
  //   MvcResult res = this.mockMvc.perform(post("/token").with(httpBasic("guusvali", "password")))
  //       .andExpect(status().isOk())
  //       .andReturn();

  //   String token = res.getResponse().getContentAsString();

  //   this.mockMvc.perform(get("/admin").header("Authorization", "Bearer " + token))
  //       .andExpect(status().isOk())
  //       .andExpect(content().string(containsString("Welcome Admin to the Room Booking Service")));
  // }

  // @Test
  // @WithMockUser
  // void rootWithMockUserStatusIsOk() throws Exception {
  //   this.mockMvc.perform(get("/admin"))
  //       .andExpect(status().isOk());
  // }
}

package com.cloud.client.CloudClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/actors", produces = "application/json")
public class ActorRestController {
	@Value("${app.message:Default}")
	  private String msg;

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public String getActor(@PathVariable("id") String id) {
	    return this.msg;
	  }
}

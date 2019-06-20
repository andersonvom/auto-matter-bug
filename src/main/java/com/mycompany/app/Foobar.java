package com.mycompany.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.norberg.automatter.AutoMatter;
import java.util.Optional;
import org.jetbrains.annotations.Nullable;

@AutoMatter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
interface Foobar {
  @Nullable
  String foo();

  Optional<String> bar();
}

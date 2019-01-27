package br.com.vvezani.springbootgraphqlsample.config;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static graphql.GraphQL.newGraphQL;

@Configuration
public class GraphqlConfig {

  private static final String GRAPHQL_SCHEMA_DIRECTORY = "graphql";

  @Autowired
  private ResourceLoader resourceLoader;

  @Bean
  public GraphQL parser(GraphQLResolver[] resolvers) throws IOException {
    String[] filesArray = new String[getFilesNames().size()];
    filesArray = getFilesNames().toArray(filesArray);
    final GraphQLSchema graphQLSchema = SchemaParser.newParser()
        .files(filesArray)
        .resolvers(resolvers).build()
        .makeExecutableSchema();
    return newGraphQL(graphQLSchema).build();
  }

  List<String> getFilesNames() throws IOException {
    List<String> result = new ArrayList<>();
    Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:/" + GRAPHQL_SCHEMA_DIRECTORY + "/*.graphqls");
    for (Resource resource : resources) {
      result.add(GRAPHQL_SCHEMA_DIRECTORY + "/" + resource.getFilename());
    }
    return result;
  }
}

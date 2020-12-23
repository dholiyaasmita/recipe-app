package io.spring.learning.recipeapp.services;

import io.spring.learning.recipeapp.commands.RecipeCommand;
import io.spring.learning.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
  Set<Recipe> getRecipe();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}

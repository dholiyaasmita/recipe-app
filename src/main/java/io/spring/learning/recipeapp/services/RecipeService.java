package io.spring.learning.recipeapp.services;

import io.spring.learning.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
  Set<Recipe> getRecipe();
}

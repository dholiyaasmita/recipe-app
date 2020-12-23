package io.spring.learning.recipeapp.bootstrap;

import io.spring.learning.recipeapp.domain.*;
import io.spring.learning.recipeapp.repositories.CategoryRepository;
import io.spring.learning.recipeapp.repositories.RecipeRepository;
import io.spring.learning.recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event){
        recipeRepository.saveAll(getRecipe());
        //log.debug("logging bootstrap data");
    }

    private List<Recipe> getRecipe(){
      List<Recipe> recipes = new ArrayList<>(2);

      //get UOM
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if (!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if (!ounceUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("dash");
        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> poundUomOptional = unitOfMeasureRepository.findByDescription("Pound");
        if (!poundUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure poundUom = poundUomOptional.get();


        //get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> indianCategoryOptional = categoryRepository.findByDescription("Indian");
        if (!indianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if (!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> canadianCategoryOptional = categoryRepository.findByDescription("Canadian");
        if (!canadianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        //get optional
        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category indianCategory = indianCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category canadianCategory = canadianCategoryOptional.get();

        //Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPreTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl."+"\n"+
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n"+"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving."+"\n"+"4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve."
        +"\n"+"Read More: https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.");

        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal(2),eachUom));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt",new BigDecimal(5),teaSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(2),tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2),tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("cilantro",new BigDecimal(2),tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper",new BigDecimal(2),dashUom));
        guacRecipe.getIngredients().add(new Ingredient("ripe tamato, seeds and pulp removed, chopped",new BigDecimal(5),eachUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        // add to return list
        recipes.add(guacRecipe);


        //yummy Lasagna
        Recipe lasagnaRecipe = new Recipe();
        lasagnaRecipe.setDescription("Vegetarian Spinach and Mushroom Lasagna");
        lasagnaRecipe.setCookTime(115);
        lasagnaRecipe.setPreTime(20);
        lasagnaRecipe.setDifficulty(Difficulty.MODERATE);
        lasagnaRecipe.setDirections("1 Sauté the mushrooms: Place mushrooms in a large (6 to 8 quart) sauté pan on high or medium high heat. Stir them with a wooden spoon or shake the pan from time to time. You may hear them squeak.\n" +
                "\n" +
                "Sprinkle salt over the mushrooms. The mushrooms will sizzle and then start to release water. (Note that you are not adding fat at this point to the pan; this method of cooking mushrooms in their own moisture is called \"dry sautéing.)\n" +
                "\n" +
                "Once the mushrooms start to release water into the pan, stir in the chopped onions. Cook until the mushrooms are no longer releasing moisture and the mushroom water has boiled away, about 5 minutes more."+"\n"+"2 Make the sauce: Add the olive oil to the mushrooms and stir to coat. Sauté the mushrooms and onions for about a minute. Add the garlic and cook for another minute.\n" +
                "\n" +
                "Stir in the tomato paste, cook for a minute longer. Reserve 1 cup of the tomato sauce (it will go in the bottom of the casserole dish), and put the remaining cup of tomato sauce into the pot with the mushrooms.  Add the large can of crushed tomatoes and one cup of water.\n" +
                "\n" +
                "Stir in the thyme, sugar, and red pepper flakes. (If you are using dried basil instead of fresh, add it now.) Bring to a simmer, then lower the heat and simmer on a low simmer, for 20 minutes."+"\n"+"3 Boil and drain the lasagna noodles: Once the sauce is simmering, salt the boiling pasta water, and add the dry lasagna noodles to the boiling water.  (The water should be at a vigorous, rolling boil.) Stir gently, making sure that the noodles are not sticking to each other. Set the timer for 8 minutes, or however long is indicated on the package of the noodles. Cook uncovered on a high boil.\n" +
                "\n" +
                "When the noodles are ready (al dente, cooked through but still firm to the bite), drain the noodles in a colander, and rinse them to cool them with cold water.  As you rinse them, gently separate them with your fingers so they don't stick to each other.Prepare a couple large cookie sheets or baking sheets by spreading a tablespoon of olive oil over the baking sheets.\n" +
                "\n" +
                "Place the lasagna noodles on the sheets, gently coating them with a bit of that olive oil, and spreading them out. This will help keep them from sticking to each other while you finish the sauce and prepare the layered casserole."+"\n"+"4 Assemble the lasagna: Turn off the heat on the stovetop for the sauce. Preheat the oven to 350°F.\n" +
                "\n" +
                "Spread the one cup of reserved tomato sauce over the bottom of a large (preferably 10x15-inch) casserole dish. (If your casserole dish is smaller, you may need to add another layer as you go through this step.)\n" +
                "\n" +
                "Place a layer of lasagna noodles down over the tomato sauce, slightly overlapping. (For our 10x15-inch dish, we ultimately fit 3 layers of 6 noodles each, with 2 extra noodles on which to nosh.)\n" +
                "\n" +
                "Sprinkle half of the ricotta cheese over the noodles, and half of the defrosted, drained, and squeezed out spinach over the ricotta.\n" +
                "\n" +
                "Sprinkle half of the mozzarella cheese over the spinach, and just a quarter of the pecorino cheese.\n" +
                "\n" +
                "Then spoon 1/3 of your mushroom sauce over the mozzarella. Sprinkle half of the fresh basil over the sauce."+"\n"+"5 Repeat layers: Repeat the layering process. Place a second layer of noodles over the sauce. Spread the remaining ricotta, spinach, and mozzarella over the noodles. Sprinkle another quarter of the pecorino along with the mozzarella. Top with another third of the mushroom sauce and the remaining fresh basil.\n" +
                "\n" +
                "Layer your final layer of lasagna noodles over the sauce. Spread the remaining sauce over the lasagna noodles, and sprinkle with the remaining pecorino or parmesan cheese."+"\n"+"6 Cover with foil and bake: Pull out a sheet of aluminum foil large enough to cover the casserole dish. Spread a little olive oil over the inside of the piece of foil (the side that will have contact with the lasagna). Place the foil over the casserole dish and crimp the edges.\n" +
                "\n" +
                "Bake at 350°F for 25 minutes, then remove the foil and bake uncovered for an additional 25 minutes.\n" +
                "\n" +
                "Take the lasagna out of the oven when done and let it rest 10 minutes before cutting to serve. Once made, the lasagna will last a week in the fridge.");

        Notes lasagnaNotes = new Notes();
        lasagnaNotes.setRecipeNotes("Lasagna makes great leftovers! You can keep this lasagna in the refrigerator for at least 5 days. Warm up slices in the microwave, or reheat the entire lasagna (covered with foil) in a 350°F oven until the cheese is bubbly.");
        lasagnaNotes.setRecipe(lasagnaRecipe);
        lasagnaRecipe.setNotes(lasagnaNotes);

        lasagnaRecipe.getIngredients().add(new Ingredient("cremini mushrooms, roughly chopped",new BigDecimal(1.5),poundUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("shiitake mushrooms, roughly chopped",new BigDecimal(1.5),poundUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("Salt",new BigDecimal(1),pinchUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("chopped onions",new BigDecimal(1),eachUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("extra virgin olive oil plus more for keeping the noodles from sticking to each other",new BigDecimal(0.25),cupUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("garlic",new BigDecimal(4),teaSpoonUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("tomato paste",new BigDecimal(6),ounceUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("tomato sauce",new BigDecimal(2),cupUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("dried thyme",new BigDecimal(1),tableSpoonUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("red pepper flakes",new BigDecimal(1.5),teaSpoonUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("sugar",new BigDecimal(1),tableSpoonUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("boxes frozen chopped spinach, thawed and squeezed in clean towel of excess moisture",new BigDecimal(10),ounceUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("lasagna noodles ",new BigDecimal(1),poundUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("container of ricotta cheese",new BigDecimal(15),ounceUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("chopped fresh basil",new BigDecimal(0.25),cupUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("pecorino cheese (or Parmesan), grated (about 1 cup)",new BigDecimal(0.25),poundUom));
        lasagnaRecipe.getIngredients().add(new Ingredient("shredded mozzarella cheese",new BigDecimal(4),cupUom));

        lasagnaRecipe.getCategories().add(americanCategory);
        lasagnaRecipe.getCategories().add(mexicanCategory);
        recipes.add(lasagnaRecipe);

        return recipes;



    }
}

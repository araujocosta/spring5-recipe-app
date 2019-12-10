package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

	private final RecipeRepository recipeRepository;
	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// recipe
		Recipe perfectGuacamole = new Recipe();
		Recipe spicyGrilledChickenTaco = new Recipe();
		
		// units of measure
		UnitOfMeasure teaspoon = unitOfMeasureRepository.findByUom("Teaspoon").get();
		UnitOfMeasure tablespoon = unitOfMeasureRepository.findByUom("Tablespoon").get();
		UnitOfMeasure cup = unitOfMeasureRepository.findByUom("Cup").get();
		UnitOfMeasure pinch = unitOfMeasureRepository.findByUom("Pinch").get();
		UnitOfMeasure ounce = unitOfMeasureRepository.findByUom("Ounce").get();
		UnitOfMeasure dash = unitOfMeasureRepository.findByUom("Dash").get();
		UnitOfMeasure pint = unitOfMeasureRepository.findByUom("Pint").get();
		UnitOfMeasure clove = unitOfMeasureRepository.findByUom("Clove").get();
		
		// categories
		Category american = categoryRepository.findByDescription("American").get();
		Category italian = categoryRepository.findByDescription("Italian").get();
		Category mexican = categoryRepository.findByDescription("Mexican").get();
		Category fastFood = categoryRepository.findByDescription("Fast Food").get();

		// ingredients
		perfectGuacamole.addIngredient(new Ingredient("Ripe avocado", new BigDecimal(2), null));
		perfectGuacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(0.5), teaspoon));
		perfectGuacamole.addIngredient(new Ingredient("Fresh lime juice", new BigDecimal(1), tablespoon));
		perfectGuacamole.addIngredient(new Ingredient("Minced red onion", new BigDecimal(0.25), cup));
		perfectGuacamole.addIngredient(new Ingredient("Serrano chiles", new BigDecimal(1), null));
		perfectGuacamole.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoon));
		perfectGuacamole.addIngredient(new Ingredient("Grated black pepper", new BigDecimal(1), dash));
		perfectGuacamole.addIngredient(new Ingredient("Ripe tomato", new BigDecimal(0.5), null));
		
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Anch chili powder", new BigDecimal(2), tablespoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Dried oregano", new BigDecimal(1), teaspoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Dried cumin", new BigDecimal(1), teaspoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Salt", new BigDecimal(0.5), teaspoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Garlic", new BigDecimal(1), clove));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Finely grated orange zest", new BigDecimal(1), tablespoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Freshly squeezed orange juice", new BigDecimal(3), tablespoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Olive oil", new BigDecimal(2), tablespoon));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Boneless chicken thighs", new BigDecimal(4), null));
		
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Corn tortillas", new BigDecimal(8), null));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Packed baby arugula", new BigDecimal(3), cup));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Ripe avocados", new BigDecimal(2), null));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Radishes", new BigDecimal(4), null));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Cherry tomatoes", new BigDecimal(0.5), pint));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Red onion", new BigDecimal(0.25), null));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), null));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Sour cream", new BigDecimal(0.5), cup));
		spicyGrilledChickenTaco.addIngredient(new Ingredient("Lime", new BigDecimal(1), null));
		
		perfectGuacamole.setDescription("Perfect guacamole");
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setCookTime(10);
		perfectGuacamole.setServings(4);
		perfectGuacamole.setSource("Simply recipes");
		perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		perfectGuacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. (See How to Cut and Peel an Avocado.) Place in a bowl.");
		perfectGuacamole.setDifficulty(Difficulty.MODERATE);
		Set<Ingredient> perfectGuacamoleIngredients = new HashSet<>();

		
		Set<Category> perfectGuacamoleCategories = new HashSet<>();
		perfectGuacamoleCategories.add(mexican);
		perfectGuacamole.setCategories(perfectGuacamoleCategories);
		

		
		Notes guacamoleNotes = new Notes();
		guacamoleNotes.setRecipeNotes("guacamole notes");
		perfectGuacamole.setNotes(guacamoleNotes);
		
		
		spicyGrilledChickenTaco.setDescription("Spicy Grilled Chicken Tacos");
		spicyGrilledChickenTaco.setPrepTime(20);
		spicyGrilledChickenTaco.setCookTime(15);
		spicyGrilledChickenTaco.setServings(5);
		spicyGrilledChickenTaco.setSource("Simply recipes");
		spicyGrilledChickenTaco.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
		spicyGrilledChickenTaco.setDirections("2 Make the marinade and coat the chicken: In a large olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.");
		spicyGrilledChickenTaco.setDifficulty(Difficulty.HARD);
		
		Set<Ingredient> spicyGrilledChickenTacoIngredients = new HashSet<>();

		Set<Category> spicyGrilledChickenTacoCategories = new HashSet<>();
		spicyGrilledChickenTacoCategories.add(mexican);
		spicyGrilledChickenTacoCategories.add(american);
		spicyGrilledChickenTaco.setCategories(spicyGrilledChickenTacoCategories);
		
		
		Notes spicyGrilledChickenTacoNotes = new Notes();
		spicyGrilledChickenTacoNotes.setRecipeNotes("spicy grilled chicken taco notes");
		spicyGrilledChickenTaco.setNotes(spicyGrilledChickenTacoNotes);
		
		recipeRepository.save(perfectGuacamole);
		recipeRepository.save(spicyGrilledChickenTaco);
		
		log.debug("Data loaded..");
	}

}

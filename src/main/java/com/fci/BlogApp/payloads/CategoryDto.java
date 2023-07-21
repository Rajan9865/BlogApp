  package com.fci.BlogApp.payloads;
  /**
   * @author Rajan.kumar
   *6:51:26 am
   */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotNull
	@Size(min = 4,message = "Min size of category title is 4")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10,message = "min size of category description is 10")
	private String categoryDescription;

}

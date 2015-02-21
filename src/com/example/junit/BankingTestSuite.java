package com.example.junit;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.example.banking.BankingTest;

@IncludeCategory(BankingCategory.class)
@RunWith(Categories.class)
@SuiteClasses({BankingTest.class, ReallySlowTest.class})
public class BankingTestSuite {

}

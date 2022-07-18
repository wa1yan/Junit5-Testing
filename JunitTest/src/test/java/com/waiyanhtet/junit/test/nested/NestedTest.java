package com.waiyanhtet.junit.test.nested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class NestedTest {

	 List<String> list;

	    @Test
	    @DisplayName("is instantiated with new ArrayList()")
	    void isInstantiatedWithNew() {
	        new ArrayList<String>();
	    }

	    @TestMethodOrder(OrderAnnotation.class)
	    @Nested
	    @DisplayName("when new")
	    class WhenNew {

	        @BeforeEach
	        void createNewStack() {
	        	list = new ArrayList<String>();
	        }

	        @Order(1)
	        @Test
	        @DisplayName("is empty")
	        void isEmpty() {
	            assertTrue(list.isEmpty());
	        }

	        @Order(2)
	        @Test
	        @DisplayName("throws IndexOutOfBoundsException when remove")
	        void throwsExceptionWhenPopped() {
	            assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(0));
	        }

	        @Order(3)
	        @Test
	        @DisplayName("throws IndexOutOfBoundsException when retrieve")
	        void throwsExceptionWhenPeeked() {
	            assertThrows(IndexOutOfBoundsException.class, ()-> list.get(0));
	        }


	        @TestMethodOrder(OrderAnnotation.class)
	        @Nested
	        @DisplayName("after adding an element")
	        class AfterPushing {

	            String anElement = "an element";

	            @BeforeEach
	            void addAnElement() {
	                list.add(anElement);
	            }

	            @Order(1)
	            @Test
	            @DisplayName("it is no longer empty")
	            void isNotEmpty() {
	                assertFalse(list.isEmpty());
	            }

	            @Order(2)
	            @Test
	            @DisplayName("returns the element when remove and is empty")
	            void returnElementWhenRemove() {
	                assertEquals(anElement, list.remove(0));
	                assertTrue(list.isEmpty());
	            }

	            @Order(3)
	            @Test
	            @DisplayName("returns the element when retrieve but remains not empty")
	            void returnElementWhenRetrieve() {
	                assertEquals(anElement, list.get(0));
	                assertFalse(list.isEmpty());
	            }
	        }
	    }
}

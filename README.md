# Solving the N+1 Problem in Spring Data JPA

The **N+1 problem** is a performance issue that occurs when fetching related entities results in multiple queries. This happens when the application executes one query to fetch a list of entities and then performs an additional query for each entity to fetch its related data, resulting in **N+1** queries.
Code and test cases shows the issue and how to solve them. 
Refer [blog](https://beyondbasics.medium.com/solving-the-n-1-problem-in-spring-data-jpa-b937eec7b599)


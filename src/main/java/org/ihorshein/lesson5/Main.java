package org.ihorshein.lesson5;

import org.ihorshein.lesson5.model.Role;
import org.ihorshein.lesson5.model.User;
import org.ihorshein.lesson5.repository.RoleRepositoryMysql;
import org.ihorshein.lesson5.repository.UserRepository;
import org.ihorshein.lesson5.repository.UserRepositoryMysql;
import org.ihorshein.lesson5.util.DbConnection;

import java.util.List;

/**
 * <a href="https://docs.google.com/document/d/1P8tzDrozFAXafJxJF4SsnxUkJZc1Q5dyV_GuikfjCHQ/edit?tab=t.0">
 *   Lesson 5 HW
 * </a>
 */
public class Main {
  public static void main(String[] args) {
    try {
      RoleRepositoryMysql roleRepositoryMysql = new RoleRepositoryMysql();

      // Adds and Gets role "client".
      Role roleClient = new Role();
      roleClient.setName("client");

      Role roleClientCreated = roleRepositoryMysql.create(roleClient);
      System.out.println("roleClientCreated: " + roleClientCreated);

      System.out.println("roleClientFound: " + roleRepositoryMysql.findById(roleClientCreated.getId()).orElseThrow());

      // Adds and Gets role "staff".
      Role roleStaff = new Role();
      roleStaff.setName("staff");

      Role roleStaffCreated = roleRepositoryMysql.create(roleStaff);
      System.out.println("roleStaffCreated: " + roleStaffCreated);

      System.out.println("roleStaffFound: " + roleRepositoryMysql.findById(roleStaffCreated.getId()).orElseThrow());

      UserRepository userRepository = new UserRepositoryMysql();

      // Adds, Gets and Updates Client A.
      User userA = new User();
      userA.setEmail("client@test.com");
      userA.setPhoneNumber("+380999379992");
      userA.setPassword("password");

      // Creates without roles.
      User userACreated = userRepository.create(userA);
      System.out.println("userACreated: " + userACreated);

      // Assign the role of the client and staff.
      userACreated.setRoles(List.of(roleClient, roleStaffCreated));
      User userAUpdated = userRepository.update(userACreated);
      System.out.println("userAUpdated: " + userAUpdated);

      System.out.println("userAFound: " + userRepository.findById(userAUpdated.getId()).orElseThrow());

      // Adds, Gets and Updates Client B.
      User userB = new User();
      userB.setEmail("staff@test.com");
      userB.setRoles(List.of(roleStaff, roleClient));

      // Creates with the role of staff and client.
      User userBCreated = userRepository.create(userB);
      System.out.println("userBCreated: " + userBCreated);

      System.out.println("userBFound_1: " + userRepository.findById(userBCreated.getId()).orElseThrow());

      // Leaves only the client's role.
      userBCreated.setRoles(List.of(roleClient));
      User userBUpdated = userRepository.update(userBCreated);
      System.out.println("userBUpdated: " + userBUpdated);

      System.out.println("userBFound_2: " + userRepository.findById(userBUpdated.getId()).orElseThrow());
    } catch (Exception e) {
      System.out.println("Something went wrong :(");
      throw e;
    } finally {
      DbConnection.close();
    }
  }
}

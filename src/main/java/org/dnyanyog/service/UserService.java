
package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	UserResponse response;
	@Autowired
	UserRequest userRequest;

	public UserResponse addUser(UserRequest request) {
		String query = "Insert into User (userId, userName, userPassword, userMail) " + "Values ('"+ request.getUserId() + "', '" + request.getUserName() + "', '" + request.getUserPassword() + "', '"	+ request.getUserMail() + "');";

		try {
			DBUtils.executeQuery(query);

			response.setUserId(request.getUserId());
			response.setUserName(request.getUserName());
			request.getUserPassword(); 
			response.setUserMail(request.getUserMail());
			response.setResponseCode("0000");
			response.setResponseMessage("user added");
		} catch (SQLException e) {
			e.printStackTrace();
			response.setResponseCode("911");
			response.setResponseMessage("add user ");

		}
		return response;
	}

	public List<UserResponse> getAllUser() {
		String querey = "select * from user";
		List<UserResponse> userListResponse = new ArrayList();

		try {
			ResultSet result = DBUtils.executeSelectQuery(querey);

			while (result.next()) {
				UserResponse userResponse = new UserResponse();
				userResponse.setUserId(result.getString(1));
				userResponse.setUserName(result.getString(2));
				userResponse.setUserMail(result.getString(4));
				userListResponse.add(userResponse);

				response.setResponseCode("0000");
				response.setResponseMessage(" User");
			}
		} catch (SQLException e) {

			response.setResponseCode("911");
			response.setResponseMessage("User");
			userListResponse.add(response);
			e.printStackTrace();
		}
		return userListResponse;
	}

}

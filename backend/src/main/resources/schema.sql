CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       user_type VARCHAR(20) NOT NULL,
                       created_at TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP NOT NULL
);

CREATE TABLE storage_requests (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  requester_id BIGINT NOT NULL,
                                  storage_space_id BIGINT NOT NULL,
                                  item_description TEXT NOT NULL,
                                  quantity INT NOT NULL,
                                  start_date DATE NOT NULL,
                                  end_date DATE NOT NULL,
                                  status VARCHAR(20) NOT NULL,
                                  created_at TIMESTAMP NOT NULL,
                                  updated_at TIMESTAMP NOT NULL,
                                  FOREIGN KEY (requester_id) REFERENCES users(id),
                                  FOREIGN KEY (storage_space_id) REFERENCES storage_spaces(id)
);


CREATE TABLE storage_requests (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  requester_id BIGINT NOT NULL,
                                  storage_space_id BIGINT NOT NULL,
                                  item_description TEXT NOT NULL,
                                  quantity INT NOT NULL,
                                  start_date DATE NOT NULL,
                                  end_date DATE NOT NULL,
                                  status VARCHAR(20) NOT NULL,
                                  created_at TIMESTAMP NOT NULL,
                                  updated_at TIMESTAMP NOT NULL,
                                  FOREIGN KEY (requester_id) REFERENCES users(id),
                                  FOREIGN KEY (storage_space_id) REFERENCES storage_spaces(id)
);

CREATE TABLE payments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          storage_request_id BIGINT NOT NULL,
                          amount DECIMAL(10, 2) NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          type VARCHAR(20) NOT NULL,
                          payment_date TIMESTAMP NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          updated_at TIMESTAMP NOT NULL,
                          FOREIGN KEY (storage_request_id) REFERENCES storage_requests(id)
);
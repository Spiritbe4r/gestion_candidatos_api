CREATE TABLE candidates (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL UNIQUE,
                            gender VARCHAR(10) NOT NULL,
                            salary_expected DECIMAL(10, 2) NOT NULL,
                            active BIT default  1,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create TABLE users(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100)  NULL,
                      email VARCHAR(100) NOT NULL UNIQUE,
                      password VARCHAR(256) NOT NULL,
                      active BIT default  1,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
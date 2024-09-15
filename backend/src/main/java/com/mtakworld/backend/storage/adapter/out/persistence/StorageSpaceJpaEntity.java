package com.mtakworld.backend.storage.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name = "storage")
@NoArgsConstructor
public class StorageSpaceJpaEntity {
	@Id
	@GeneratedValue
	Long id;
}

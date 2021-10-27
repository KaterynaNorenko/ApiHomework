package helpers;

import java.util.Map;

import org.testng.collections.Maps;

import com.google.common.collect.ImmutableMap;


public final class MapHelper {

	private MapHelper() {
	}

	public static <K, V> Map<K, V> mapOf(K k1, V v1) {
		return Maps.newHashMap(ImmutableMap.of(k1, v1));
	}

	public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2) {
		return Maps.newHashMap(ImmutableMap.of(k1, v1, k2, v2));
	}

	public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3) {
		return Maps.newHashMap(ImmutableMap.of(k1, v1, k2, v2, k3, v3));
	}
}
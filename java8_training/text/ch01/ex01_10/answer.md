| Collection's method | target interface | default or static |
|--------|--------|---------|
| static <T> boolean	addAll(Collection<? super T> c, T... elements) | Collection | static |
| static <T> Queue<T> asLifoQueue(Deque<T> deque) | Deque | default |
| static <T> int	binarySearch(List<? extends Comparable<? super T>> list, T key) | List | default |
| static <T> int	binarySearch(List<? extends T> list, T key, Comparator<? super T> c) | List | default |
| static <E> Collection<E> checkedCollection(Collection<E> c, Class<E> type) | Collection | static |
| static <E> List<E>	checkedList(List<E> list, Class<E> type) | List | static |
| static <K,V> Map<K,V> checkedMap(Map<K,V> m, Class<K> keyType, Class<V> valueType) | Map | static |
| static <E> Set<E> checkedSet(Set<E> s, Class<E> type) | Set | static |
| static <K,V> SortedMap<K,V> checkedSortedMap(SortedMap<K,V> m, Class<K> keyType, Class<V> valueType) | SortedMap | static |
| static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s, Class<E> type) | SortedSet | static |
| static <T> void copy(List<? super T> dest, List<? extends T> src) | List | static |
| static boolean disjoint(Collection<?> c1, Collection<?> c2) | Collection | static |
| static <T> List<T> emptyList() | List | static |
| static <K,V> Map<K,V> emptyMap() | Map | static |
| static <T> Set<T> emptySet() | Set | static |
| static <T> Enumeration<T> enumeration(Collection<T> c) | Collection | default |
| static <T> void fill(List<? super T> list, T obj) | List | default |
| static int frequency(Collection<?> c, Object o) | Collection | default |
| static int indexOfSubList(List<?> source, List<?> target) | List | default |
| static int lastIndexOfSubList(List<?> source, List<?> target) | List | default |
| static <T> ArrayList<T> list(Enumeration<T> e) | Enumeration | static |
| static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) | Collection | static |
| static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) | Collection | static |
| static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) | Collection | static |
| static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) | Collection | static |
| static <T> List<T> nCopies(int n, T o) | List | static |
| static <E> Set<E> newSetFromMap(Map<E,Boolean> map) | Map | default |
| static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) | List | default |
| static void reverse(List<?> list) | List | default |
| static <T> Comparator<T> reverseOrder() | Comparator | default |
| static <T> Comparator<T> reverseOrder(Comparator<T> cmp) | Comparator | default |
| static void rotate(List<?> list, int distance) | List | default |
| static void shuffle(List<?> list) | List | default |
| static void shuffle(List<?> list, Random rnd) | List | default |
| static <T> Set<T> singleton(T o) | Set | static |
| static <T> List<T> singletonList(T o) | List | static |
| static <K,V> Map<K,V> singletonMap(K key, V value) | Map | static |
| static <T extends Comparable<? super T>> void sort(List<T> list) | List | default |
| static <T> void sort(List<T> list, Comparator<? super T> c) | List | default |
| static void swap(List<?> list, int i, int j) | List | default |
| static <T> Collection<T> synchronizedCollection(Collection<T> c) | Collection | default |
| static <T> List<T> synchronizedList(List<T> list) | List | default |
| static <K,V> Map<K,V> synchronizedMap(Map<K,V> m) | Map | default |
| static <T> Set<T> synchronizedSet(Set<T> s) | Set | default |
| static <K,V> SortedMap<K,V> synchronizedSortedMap(SortedMap<K,V> m) | SortedMap | default |
| static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s) | SortedSet | default |
| static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c) | Collection | default |
| static <T> List<T> unmodifiableList(List<? extends T> list) | List | default |
| static <K,V> Map<K,V> unmodifiableMap(Map<? extends K,? extends V> m) | Map | default |
| static <T> Set<T> unmodifiableSet(Set<? extends T> s) | Set | default |
| static <K,V> SortedMap<K,V> unmodifiableSortedMap(SortedMap<K,? extends V> m) | SortedMap | default |
| static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<T> s) | SortedSet | default |

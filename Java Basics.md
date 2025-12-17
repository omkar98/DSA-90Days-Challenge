# JAVA MINDMAP

## PILLARS
- **Abstraction**
    - Interfaces + Abstract classes
    - Security + Implementation hiding
- **Encapsulation**
    - (Data + method)
    - Data hiding
    - var (private) + getters/setters
- **Inheritance**
    - "extends" keyword
    - Code reusability
    - Can achieve polymorphism
- **Polymorphism** (Many forms)
    - Compile time / Static / Overloading
        - Return type differs, arg diff
        - Handled by compiler
    - Runtime / Dynamic / Overriding
        - JVM handles
    - *Note: Method hiding (static methods) is different from overriding*

## RELATIONSHIPS
- **is-a** (Inheritance)
    - e.g., Dog is an animal
- **has-a** (Association)
    - **Aggregation**
        - Weak association
        - Survive individually
    - **Composition**
        - Strong association
        - If container dies, contained object dies

## CLASSES
- **Types**
    - Concrete
    - Abstract (cannot instantiate)
    - POJO (Plain Old Java Object)
- **Nested Classes (NC)**
    - Static NC
    - Non-static NC (Inner Class)
        - Member Inner
        - Local Inner
        - Anonymous Inner
- **Special Classes**
    - **Singleton Class**: Only 1 object is created
    - **Immutable Class**: Cannot change value after creation (e.g., String)
        - class final, vars private final, no setters, constructor initializes

## INTERFACE
- **Nature**
    - 100% Abstract (prior to Java 8)
    - "implements" keyword
    - Multiple inheritance support
- **Methods allowed**
    - public abstract (implicit)
    - default methods (Java 8+)
    - static methods (Java 8+)
    - private methods (Java 9+)
- **Types of Interfaces**
    - Normal (methods > 1)
    - Marker (no methods, e.g., Serializable, Cloneable)
    - Functional (SAM - Single Abstract Method, e.g., Runnable, Callable)

## OTHER FEATURES
- **Annotations**: Metadata (e.g., @Override, @Deprecated)
- **Reflection**: Inspecting code at runtime
- **Generics**: Type Erasure concept (ensures backward compatibility)
- **Exception Handling**: Checked vs Unchecked

## MEMORY MGMT & VARIABLES
- **Variables**
    - **Primitives** (Stack)
        - byte, short, int, long, float, double, char, boolean
    - **Reference Types** (Heap)
        - Class, Interface, Array, String
    - **Autoboxing/Unboxing**: Automatic conversion between primitive and wrapper classes.
- **Comparison**
    - `==` : memory address comparison
    - `.equals()` : content comparison (if overridden)
- **JVM Memory Structure**
    - **Stack Memory**:
        - LIFO (Last In First Out)
        - Stores primitive vars & object references
        - Thread-safe (each thread has own stack)
    - **Heap Memory**:
        - Stores Objects
        - **Young Generation**:
            - Eden Space (New objects)
            - Survivor Spaces (S0, S1)
            - *Minor GC happens here*
        - **Old Generation**: Long-lived objects
        - **Metaspace** (Java 8+): Metadata, class definitions (replaces PermGen)
        - *Garbage Collection (GC) Algorithms*: Mark & Sweep, CMS, G1 GC.

## CONSTRUCTORS
- **Purpose**: Initialize object
- No return type
- Same name as class
- Types: Default, No-arg, Parameterized
- `super()` and `this()` calls
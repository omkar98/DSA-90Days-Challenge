# Project Idea: **A Notification System for a Blogging Platform**

## **Description**
This project involves a notification system for a blogging platform where users receive notifications based on their preferences. The system is designed using multiple design patterns for scalability and maintainability.

---

## **Features**
1. **Notification Preferences (Strategy Pattern)**:
    - Users can choose their preferred notification method: email, SMS, or push notifications.
    - Adding new notification methods is seamless and does not require modifying existing logic.

2. **Customizable Notifications (Decorator Pattern)**:
    - Notifications can be enhanced dynamically, such as adding promotional text or tracking links.

3. **Dynamic Subscription Management (Observer Pattern)**:
    - Users can subscribe or unsubscribe from notifications at any time.
    - The system dynamically updates subscribers without requiring changes to the core functionality.

4. **Centralized Notification Creation (Factory Pattern)**:
    - A factory creates different types of notifications, simplifying the creation process and promoting consistency.

---
1. **Lack of Extensibility (Notification Methods)**
   - Issue: The notification methods (e.g., Email, SMS, Push) were hardcoded into the Notification class.
   - Problem: Adding a new notification method (e.g., WhatsApp) required modifying the Notification class directly, violating the Open-Closed Principle.
   - Impact: High risk of introducing bugs and increasing complexity with every new notification method. 
   
2. **Tight Coupling (Subscribers and Notifications)**
      - Issue: The BloggingPlatform class directly managed the subscribers and handled notifications.
      - Problem: The system was tightly coupled, making it difficult to dynamically add or remove subscribers or modify how notifications were sent.
      - Impact: Lack of flexibility and increased effort to manage subscriptions. 
3. **Redundancy in Notification Creation**
      - Issue: Notification objects were manually instantiated (new Notification(...)) throughout the code.
      - Problem: This led to repeated code, inconsistency, and potential errors when creating notifications.
      - Impact: Poor maintainability and scalability.
4. **Inability to Customize Notifications Dynamically**
      - Issue: The Notification class was static, and customizing notifications (e.g., adding promotional content or tracking links) required modifying the class.
      - Problem: Customization logic could not be reused or combined dynamically.
      - Impact: Code became bloated and difficult to manage.
5. **Lack of Reusability and Single Responsibility**
      - Issue: The Notification class was handling multiple responsibilities: message creation, formatting, and delivery.
      - Problem: This violated the Single Responsibility Principle, making the code harder to test and maintain.
      - Impact: Difficult to debug and extend functionality.
6. **Hardcoded Logic for Subscription Management**
      - Issue: Adding or removing subscribers required directly modifying the subscriber list in BloggingPlatform.
      - Problem: This approach was error-prone and not reusable for other use cases.
      - Impact: The code lacked flexibility and scalability.
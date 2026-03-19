Precious Ikejiofor
Professor Woolfolk
CSCI 363
19 March 2026

Redesigned System Using CRC Cards

Class: Order
Responsibilities:
- Store order information (customer name, email, item, price)
- Provide order details to other components
- Calculate subtotal
- Validate order data

Collaborators: None

---

Class: TaxCalculator
Responsibilities:
- Calculate tax based on order price and location
- Support different tax rates for different regions
- Provide tax breakdown

Collaborators: Order

---

Class: DiscountProcessor
Responsibilities:
- Determine if order qualifies for discounts
- Apply applicable discounts to order total
- Support different discount rules
- Calculate final price after discounts

Collaborators: Order

---

Class: ReceiptPrinter
Responsibilities:
- Format order details for display
- Generate receipt content
- Print receipt to specified output
- Include tax and discount information

Collaborators: Order, TaxCalculator, DiscountProcessor

---

Class: OrderRepository
Responsibilities:
- Save order to persistent storage
- Retrieve order history
- Handle file/database I/O operations
- Generate order IDs

Collaborators: Order

---

Class: EmailService
Responsibilities:
- Send confirmation emails
- Format email content
- Handle email delivery failures
- Manage email templates

Collaborators: Order

---

Class: AuditLogger
Responsibilities:
- Log order processing events
- Record timestamps and order details
- Support different log destinations

Collaborators: Order

---

Class: OrderProcessor (Orchestrator)
Responsibilities:
- Coordinate the complete order processing workflow
- Delegate tasks to specialized components
- Manage the flow of data between collaborators
- Handle exceptions and rollback if necessary
- Ensure consistent order processing

Collaborators: Order, TaxCalculator, DiscountProcessor, ReceiptPrinter, OrderRepository, EmailService, AuditLogger
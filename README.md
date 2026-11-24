# Multi-Tenant SaaS POS System

A full-stack, multi-tenant Point of Sale (POS) and retail management platform built with **Java Spring Boot**, **React**, **Redux**, and **MySQL**. Designed to support multi-branch retail operations with dedicated role-based dashboards, real-time inventory alerts, shift reporting, and integrated payment gateways.

---

## ✨ Key Dashboards

- **💰 Cashier Terminal:** Fast, customer-facing checkout interface for billing, discounts, loyalty point redemptions, invoice printing, and refund processing.
- **📊 Branch Manager Dashboard:** Single-location oversight featuring shift reports, daily sales analytics, staff performance, and local stock monitoring.
- **🏢 Store Admin Panel:** Centralized multi-location management system for branches, catalogs, role-based access control (RBAC), and organization-wide KPIs.

---

## 🔥 Enterprise Features (50+)

- **Multi-Tenant & Multi-Branch Architecture:** Isolated tenant workspaces with centralized control across multiple store locations.
- **Role-Based Access Control (RBAC):** Granular permissions powered by Spring Security for Store Admins, Branch Managers, and Cashiers.
- **Real-Time Inventory Tracking:** Automated stock updates on every sale/refund with configurable low-stock alerts.
- **Payment Gateway Integrations:** Seamless checkout support for **Razorpay** and **Stripe**, alongside cash and split payments.
- **Customer Loyalty Points System:** Earn and redeem reward points directly at the cashier terminal.
- **Invoice Generation & Printing:** Instant receipt generation and thermal/standard invoice printing.
- **Complete Refund Processing:** Full and partial return workflows with automatic inventory and ledger reconciliation.
- **Shift Reports & Sales Analytics:** End-of-shift cash drawer reconciliation, daily sales breakdowns, revenue trends, and KPI tracking.

---

## 💻 Technology Stack

### Frontend
- **React** – Component-based UI architecture
- **Redux** – Centralized state management (**16 reducers** covering auth, cart, inventory, branches, analytics, and more)
- **shadcn/ui** – Accessible, modern UI components
- **Axios** – HTTP client with interceptors for authenticated API requests
- **Cloudinary** – Cloud-based product and receipt image storage

### Backend
- **Java Spring Boot** – Enterprise REST backend
- **Spring Security** – JWT-based authentication & role authorization
- **Spring Data JPA / Hibernate** – Object-relational mapping and multi-tenant data persistence
- **MySQL** – Relational database management
- **RESTful APIs** – **14+ modular API controllers** for billing, inventory, branches, customers, reports, and payments

### Payment Integrations
- **Razorpay** – Online & UPI/card payment processing
- **Stripe** – International card payment processing

---

## 📂 Project Structure

```text
Multi-Tenant-SaaS-POS-with-Spring-Boot-React-Redux/
├── backend/                  # Spring Boot REST API (14+ modules)
│   ├── src/main/java/...     # Controllers, Services, Repositories, Security, Entities
│   └── src/main/resources/   # application.properties / application.yml
├── frontend/                 # React + Redux + shadcn/ui client
│   ├── src/components/       # Reusable UI & dashboard components
│   ├── src/redux/            # Store & 16 feature reducers
│   └── src/services/         # Axios API integration modules
└── README.md

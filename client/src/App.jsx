import React, { useState, useEffect } from 'react';

export default function App() {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Simulated API response from /api/v1/tasks
    setTasks([
      { id: 101, title: 'Spring Security 6 Migration', status: 'IN_PROGRESS', priority: 'HIGH', assignee: 'DevOps Lead' },
      { id: 102, title: 'PostgreSQL Connection Pooling Tuning', status: 'COMPLETED', priority: 'URGENT', assignee: 'DBA' },
      { id: 103, title: 'Audit Trail Immutable Event Stream', status: 'IN_REVIEW', priority: 'MEDIUM', assignee: 'Backend Eng' }
    ]);
    setLoading(false);
  }, []);

  return (
    <div style={{ padding: '2rem', fontFamily: 'system-ui, sans-serif', background: '#0b0d12', color: '#f8fafc', minHeight: '100vh' }}>
      <header style={{ borderBottom: '1px solid #1e2535', paddingBottom: '1rem', marginBottom: '2rem' }}>
        <h1 style={{ margin: 0, color: '#4a9eff' }}>TaskFlow Enterprise</h1>
        <p style={{ margin: '0.5rem 0 0 0', color: '#94a3b8' }}>Personnel &amp; Task Orchestration Dashboard</p>
      </header>
      
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))', gap: '1.5rem' }}>
        {tasks.map(task => (
          <div key={task.id} style={{ background: 'rgba(17,20,24,0.85)', border: '1px solid #1e2535', borderRadius: '8px', padding: '1.25rem' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '0.75rem' }}>
              <span style={{ fontSize: '0.75rem', color: '#64748b', fontFamily: 'monospace' }}>#{task.id}</span>
              <span style={{ fontSize: '0.75rem', background: task.status === 'COMPLETED' ? 'rgba(77,219,135,0.15)' : 'rgba(74,158,255,0.15)', color: task.status === 'COMPLETED' ? '#4ddb87' : '#4a9eff', padding: '2px 8px', borderRadius: '4px' }}>
                {task.status}
              </span>
            </div>
            <h3 style={{ margin: '0 0 0.5rem 0', fontSize: '1.1rem' }}>{task.title}</h3>
            <p style={{ margin: 0, fontSize: '0.85rem', color: '#94a3b8' }}>Assignee: <strong>{task.assignee}</strong></p>
          </div>
        ))}
      </div>
    </div>
  );
}
